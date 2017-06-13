package maxShamanovskyi.controller;

import io.swagger.annotations.*;
import maxShamanovskyi.model.Country;
import maxShamanovskyi.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/country")
@Api(value = "/country", description = "Country REST service")
public class CountryController {

    @Autowired
    CountryService service;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Get all countries", response = Iterable.class)
    public List<Country> findAll(){
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/find/{name}", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Get country by name", response = Country.class)
    public Country findByName(@PathVariable String name){
        return service.findByName(name);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Create country", response = Country.class)
    public ResponseEntity create(@RequestBody Country country){
        return service.create(country) != null
                ? new ResponseEntity("Country create successfully", HttpStatus.CREATED)
                : new ResponseEntity("Country create failed", HttpStatus.BAD_REQUEST);

    }

    @RequestMapping(value = "/addP", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Create country by params", response = Country.class)
    public ResponseEntity create(@RequestParam String name,
                                 @RequestParam Double population,
                                 @RequestParam Double area,
                                 @RequestParam String president,
                                 @RequestParam String vicePresident,
                                 @RequestParam String capital,
                                 @RequestParam Map<String, Double> languages,
                                 @RequestParam Double gdp){
        Country country = new Country(name, population, area, president, vicePresident, capital, languages, gdp);
        return service.create(country) != null
                ? new ResponseEntity("Country create successfully", HttpStatus.CREATED)
                : new ResponseEntity("Country create failed", HttpStatus.BAD_REQUEST);

    }

    @RequestMapping(value = "/update/{name}", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "Update country")
    public ResponseEntity update(@PathVariable String name, @RequestBody Country country){
        service.update(country);
        return new ResponseEntity("Country update successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{name}", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "Delete country")
    public ResponseEntity  delete(@PathVariable String name){
        service.delete(name);
        return new ResponseEntity("Country delete successfully", HttpStatus.OK);
    }
}
