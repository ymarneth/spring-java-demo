import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MyEntity} from "../models/my-entity";

@Injectable({
  providedIn: 'root'
})
export class MyEntityService {

  constructor(private http: HttpClient) {
  }

  findAll(): Observable<MyEntity[]> {
    const url = '/api/my-entity';
    return this.http.get<MyEntity[]>(url);
  }

  createEntity(): Observable<MyEntity> {
    const url = '/api/my-entity';
    return this.http.post<MyEntity>(url, {});
  }
}
