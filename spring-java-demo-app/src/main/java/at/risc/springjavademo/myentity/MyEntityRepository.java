package at.risc.springjavademo.myentity;

import org.springframework.data.jpa.repository.JpaRepository;

interface MyEntityRepository extends JpaRepository<MyEntity, Long> {
}
