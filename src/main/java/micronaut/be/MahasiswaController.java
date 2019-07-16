package micronaut.be;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Delete;
import io.micronaut.validation.Validated;

import java.util.List;

@Validated
@Controller("/mahasiswa")
public class MahasiswaController {

    private MahasiswaRepository mahasiswaRepository;

    public MahasiswaController(MahasiswaRepository mahasiswaRepository) {
        this.mahasiswaRepository = mahasiswaRepository;
    }

    @Get("/")
    public List<Mahasiswa> list() {
        return mahasiswaRepository.findAll();
    }

    @Get("/{id}") 
    public Mahasiswa show(Long id) {
        return mahasiswaRepository
                .findById(id)
                .orElse(null); 
    }

    @Post("/")
    public Mahasiswa create(@Body Mahasiswa mahasiswa) {

        return mahasiswaRepository.save(mahasiswa);
    }

    @Post("/edit/{id}") 
    public Mahasiswa update(@Body Mahasiswa mahasiswa) {
        return mahasiswaRepository.update(mahasiswa); 
    }

    @Delete("/delete/{id}")
    public List<Mahasiswa> delete(Long id) {
         mahasiswaRepository.deleteById(id);

         return mahasiswaRepository.findAll();
    }
}
