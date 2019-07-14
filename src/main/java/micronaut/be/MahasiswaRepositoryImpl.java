package micronaut.be;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Singleton
public class MahasiswaRepositoryImpl implements MahasiswaRepository{
    @PersistenceContext
    private EntityManager entityManager;

    public MahasiswaRepositoryImpl(@CurrentSession EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Mahasiswa save(@NotNull Mahasiswa mahasiswa) {
        entityManager.persist(mahasiswa);
        return mahasiswa;
    }

    @Override
    @Transactional
    public Mahasiswa update(@NotNull Mahasiswa mahasiswa) {
        return entityManager.merge(mahasiswa);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mahasiswa> findAll() {
        String qlString = "SELECT e FROM Mahasiswa e";
        TypedQuery<Mahasiswa> query = entityManager.createQuery(qlString, Mahasiswa.class);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Mahasiswa> findById(@NotNull Long id) {
        return Optional.ofNullable(entityManager.find(Mahasiswa.class, id));
    }
}
