package com.trainee.service.implement;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.trainee.model.Subject;
import com.trainee.repository.SubjectRepository;
import com.trainee.service.SubjectService;

import lombok.extern.java.Log;

@Log
@Service
public class SubjectServiceImplement implements SubjectService {

  @Autowired
  SubjectRepository subjectRepository;

  @Override
  public List<Subject> getAll() {
    log.info("Getting all subjects");
    return (List<Subject>) subjectRepository.findAll();
  }

  @Override
  public Subject getById(int subjectId) {
    log.info("Getting subject by id");
    Subject subjects = subjectRepository.findById(subjectId);
    return subjects;
  }

  @Override
  public Subject post(Subject subject) {
    if (subjectRepository.findById(subject.getId()) == null) {
      log.info("Subject was created");
      return subjectRepository.save(subject);
    } else {
      log.info("Can't create a Subject");
      return subject;
    }
  }

  @Override
  public void putById(int subjectId, Subject subject) {
    if (subjectRepository.findById(subject.getId()) != null) {
      log.info("Subject was updated");
      subject.setId(subjectId);
      subjectRepository.save(subject);
    } else {
      log.info("Can't update a Subject");
    }
  }

  @Override
  public void delete(int subjectId) {
    if (subjectRepository.findById(subjectId) != null) {
      log.info("Subject was deleted");
      subjectRepository.softDelete(subjectId);
    }
  }

  @Override
  public void patchById(int subjectId, Map<String, Object> fields) {
    Subject subject = getById(subjectId);

    fields.forEach((k, v) -> {

      Field field = ReflectionUtils.findRequiredField(Subject.class, k);
      field.setAccessible(true);
      ReflectionUtils.setField(field, subject, v);
    });
    log.info("Subject was patched");
    subjectRepository.save(subject);

  }

}
