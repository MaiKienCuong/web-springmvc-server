package maikiencuong.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Lophoc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(columnDefinition = "nvarchar(255)")
	private String shortName;

	@Column(columnDefinition = "nvarchar(255)")
	private String longName;

	@JsonIgnore
	@OneToMany(mappedBy = "lophoc", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Sinhvien> sinhviens;

}
