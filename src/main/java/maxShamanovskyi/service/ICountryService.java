package maxShamanovskyi.service;

import maxShamanovskyi.model.Country;
import maxShamanovskyi.repository.CountryRepository;
import maxShamanovskyi.util.CountryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICountryService implements CountryService {

    @Autowired
    private CountryRepository repository;

    @Override
    public List<Country> findAll() {
        return repository.findAll();
    }

    @Override
    public Country findByName(String name) {
        if (!CountryUtil.isValidString(name)) {
            return new Country();
        }
        return repository.findByName(name);
    }

    @Override
    public Country create(Country country) {
        if (CountryUtil.isValidCountry(country)) {
            return repository.insert(country);
        }
        return null;
    }

    @Override
    public void update(Country country) {
        if (CountryUtil.isValidCountry(country)) {
            repository.save(country);
        }
    }

    @Override
    public void delete(String name) {
        Country country = repository.findByName(name);
        if (country != null) {
            repository.delete(country);
        }
    }
}
