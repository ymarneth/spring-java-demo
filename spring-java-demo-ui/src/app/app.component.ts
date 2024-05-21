import {Component, DestroyRef, OnInit} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {lastValueFrom} from "rxjs";
import {MyEntity} from "./models/my-entity";
import {MyEntityService} from "./services/my-entity.service";
import {AsyncPipe, NgForOf} from "@angular/common";
import {takeUntilDestroyed} from "@angular/core/rxjs-interop";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, AsyncPipe, NgForOf],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  title = 'Spring Java Demo UI';

  myEntities?: MyEntity[];

  constructor(private myEntityService: MyEntityService,
              private destroyRef: DestroyRef) {
  }

  async ngOnInit(): Promise<void> {
    this.myEntities = await lastValueFrom(this.myEntityService.findAll());
  }

  createEntity(): void {
    this.myEntityService.createEntity()
      .pipe(takeUntilDestroyed(this.destroyRef))
      .subscribe(newEntity => this.myEntities = [...(this.myEntities || []), newEntity]);
  }
}
