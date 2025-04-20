package org.services.crime.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "case_table")
public class Case {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;

	@Column(name="description")
	private String description;

	@Column(name="status")
	private String status;

	@Column(name="date_reported")
	private Timestamp dateReported;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "investigating_officer_id", referencedColumnName = "id", unique = false)
    private InvestigatingOfficer investigatingOfficer;

    @OneToMany(mappedBy = "caseObj", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Evidence> evidences = new ArrayList<>();

    @OneToMany(mappedBy = "caseObj", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Victim> victims = new ArrayList<>();

    @OneToMany(mappedBy = "caseObj", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Suspect> suspects = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "legal_action_id", referencedColumnName = "id", unique = false)
    private LegalAction legalAction;
}
