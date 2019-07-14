package micronaut.be;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.List;

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

    @Post("/")
    public Mahasiswa create(@Body Mahasiswa mahasiswa) {
        return mahasiswaRepository.save(mahasiswa);
    }


}
