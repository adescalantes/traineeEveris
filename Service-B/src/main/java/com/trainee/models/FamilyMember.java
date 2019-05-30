package com.trainee.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Clase Entity de FamilyMember
 * <p>
 * Se mapea la base de datos
 * 
 * @author aescalan
 * @version 1.0
 */
@Entity
@Table(name = "family_members")
@Data
public class FamilyMember {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "family_member_id")
  private int id;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "family_id", referencedColumnName = "family_id")
  private Family family;

  @Column(name = "parent_or_studen_member")
  private String parentOrStudent;

  @OneToOne
  @JoinColumn(name = "parent_id", referencedColumnName = "parent_id")
  private Parent parent;

  @OneToOne
  @JoinColumn(name = "student_id", referencedColumnName = "student_id")
  private Student student;

}
