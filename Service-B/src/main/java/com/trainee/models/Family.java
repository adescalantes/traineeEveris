package com.trainee.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Clase Entity de Family
 * <p>
 * Se mapea la base de datos
 * 
 * @author aescalan
 * @version 1.0
 */
@Entity
@Table(name = "families")
@Data
public class Family {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "family_id")
  private int id;

  @OneToOne
  @NotNull
  @JoinColumn(name = "parent_id", referencedColumnName = "parent_id")
  private Parent parent;

  @JsonIgnore
  @OneToMany(mappedBy = "family")
  private List<FamilyMember> familyMember;

  @Column(name = "family_name")
  private String familyName;

}
