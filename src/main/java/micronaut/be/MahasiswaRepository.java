package micronaut.be;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface MahasiswaRepository {
    Mahasiswa save(@NotNull Mahasiswa mahasiswa);
    Mahasiswa update(@NotNull Mahasiswa mahasiswa);
    List<Mahasiswa> findAll();
    Optional<Mahasiswa> findById(@NotNull Long id);
}