//package dev.vorstu.Service;
//
//import dev.vorstu.Mappers.StudentDataMapper;
//import dev.vorstu.entity.Student;
//import dev.vorstu.entity.StudentDTO;
//import dev.vorstu.entity.User;
//import dev.vorstu.repositories.StudentRepository;
//import dev.vorstu.repositories.UserRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//@Slf4j
//@Service
//public class studentService {
//
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    //@Override
////    public List<Student> getAll() {
////        return StudentRepository.findAllByOrderByIdAsc();
////    }
//
////    public List<Student> getAll(PageRequest pageRequest) {
////        List<Student> list = StudentRepository.findAllByOrderByIdAsc(pageRequest);
////        return list;
////    }
//
////    public Page<Student> getAll(PageRequest pageRequest) {
////        Page<Student> page = StudentRepository.findAllByOrderByIdAsc(pageRequest);
////        return page;
////    }
//
//    public Page<StudentDTO> getAll(PageRequest pageRequest) {
//        Page<Student> page = studentRepository.findAllByOrderByIdAsc(pageRequest);
//        Page<StudentDTO> pageDTO = page.map(new Function<Student, StudentDTO>(){
//
//            public StudentDTO apply(Student student){
//               // StudentDTO studentDTO = new StudentDTO();
//                StudentDTO studentDTO = StudentDataMapper.INSTANCE.StudentToStudentDTO(student);
//                return studentDTO;
//            }
//        });
//
//        return pageDTO;
//    }
//
//
//    public StudentDTO getById(long id) {
//
//        Student student = studentRepository.findById(id).get(); // bez get oshibka
//        StudentDTO studentDTO = StudentDataMapper.INSTANCE.StudentToStudentDTO(student);
//        if (student == null){
//            log.info("Cant find by id");
//        }
//        return studentDTO;
//    }
//
////    public Student getById(long id) {
////
////        Student student = studentRepository.findById(id).get(); // bez get oshibka
////        if (student == null){
////            log.info("Cant find by id");
////        }
////        return student;
////    }
//
//    public Student getByName(String name) {
//        Student student = studentRepository.findByFio(name);
//        if (student == null){
//            log.info("Cant find by name");
//        }
//        return student;
//    }
//
//
//    public Student create(Student editingStudent) {
//        Student student = new Student();
//        student.setFio(editingStudent.getFio());
//        student.setId(editingStudent.getId());
//        student.setGroup(editingStudent.getGroup());
//        student.setPhoneNumber(editingStudent.getPhoneNumber());
//        return studentRepository.save(student);
//    }
//
//
//    public Student update(long id, Student updatingStudent) {
//        if (!studentRepository.existsById(id)) {
//            log.info("Cant find student");
//        }
//        Student student = new Student();
//        student.setFio(updatingStudent.getFio());
//        student.setId(updatingStudent.getId());
//        student.setGroup(updatingStudent.getGroup());
//        student.setPhoneNumber(updatingStudent.getPhoneNumber());
//        return studentRepository.save(student);
//    }
//
//
//    public void delete(long id) {
//        if (!studentRepository.existsById(id)) {
//            log.info("Cant find student when deleting");
//        }
//        studentRepository.deleteById(id);
//    }
//
//}
