package maxShamanovskyi.repository;

import maxShamanovskyi.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "country", path = "country")
public interface CountryRepository extends MongoRepository<Country, String> {

    Country findByName(@Param("name") String name);

}
