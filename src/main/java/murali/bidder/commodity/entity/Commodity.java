package murali.bidder.commodity.entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table("commodities")
public class Commodity {

	@PrimaryKey
	@Column
	private String cid;
	
	@Column
	private String description;
	
	@Column
	private String email;
	
	@Column
	private String name;
	
	@Column
	private String pic_link;
}
