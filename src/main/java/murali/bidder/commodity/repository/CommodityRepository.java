package murali.bidder.commodity.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import murali.bidder.commodity.entity.Commodity;

@Repository
public interface CommodityRepository extends CassandraRepository<Commodity, String> {

	public Commodity findByCid(String cid);

}
