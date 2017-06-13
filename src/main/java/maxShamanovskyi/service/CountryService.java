package maxShamanovskyi.service;

import maxShamanovskyi.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAll();
    Country findByName(String name);
    Country create(Country country);
    void update(Country country);
    void delete(String name);

}
