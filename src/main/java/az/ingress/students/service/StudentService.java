package az.ingress.students.service;

import az.ingress.students.errors.Errors;
import az.ingress.students.exception.ApplicationException;
import az.ingress.students.domain.Student;
import az.ingress.students.dto.StudentDto;
import az.ingress.students.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;
    private final ModelMapper mapper;

    public Page<StudentDto> getALl(Pageable page) {
        return repository.findAll(page)
                .map((f) -> mapper.map(f, StudentDto.class));
    }

    public StudentDto getOne(Long id) {
        return repository.findById(id)
                .map((f) -> mapper.map(f, StudentDto.class))
                .orElseThrow(() -> new ApplicationException(Errors.STUDENT_NOT_FOUND, Map.of("id", id)));
    }

    public StudentDto create(StudentDto dto) {
        Student result = repository.save(mapper.map(dto, Student.class));
        return mapper.map(result, StudentDto.class);
    }

    public StudentDto update(Long id, StudentDto dto) {
        repository.findById(id)
                .orElseThrow(() -> new ApplicationException(Errors.STUDENT_NOT_FOUND, Map.of("id", id)));
        dto.setId(id);
        Student result = repository.save(mapper.map(dto, Student.class));
        return mapper.map(result, StudentDto.class);
    }
}
