package ${class.typePackage};
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.${class.name}Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uns.ftn.mbrs.model.*;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping(value = "/api/${class.name?lower_case}s/")
public class ${class.name?cap_first}Controller {

    @Autowired
    private ${class.name?cap_first}Service ${class.name?lower_case}Service;

    @GetMapping(value = "all${class.name}s")
    public ResponseEntity getAll${class.name}() {

        List<${class.name?cap_first}> all${class.name?cap_first}s = this.${class.name?lower_case}Service.getAll();

        if (all${class.name?cap_first}s.isEmpty()) {
        return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(all${class.name?cap_first}s, HttpStatus.OK);
    }

    @GetMapping(value = "one${class.name}")
    public ResponseEntity getOne${class.name}(@RequestParam Long id) {

        Optional<${class.name?cap_first}> ${class.name?lower_case} = ${class.name?lower_case}Service.getOne(id);

        if (${class.name?lower_case} == null) {
            return ResponseEntity.notFound().build();        }

        return new ResponseEntity(${class.name?lower_case}, HttpStatus.OK);
    }



    @DeleteMapping(value = "delete${class.name}")
    public ResponseEntity delete${class.name}(@RequestParam Long id) {

        ${class.name?lower_case}Service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "update${class.name}")
    public ResponseEntity update${class.name}(@RequestBody ${class.name?cap_first} ${class.name?lower_case}) {

        if (${class.name?lower_case} == null) {
            return ResponseEntity.notFound().build();
        }

        ${class.name?lower_case}Service.update(${class.name?lower_case});
        return ResponseEntity.ok().build();
    }


    @PostMapping(value = "add${class.name}")
    public ResponseEntity add${class.name}(@RequestBody ${class.name?cap_first} ${class.name?lower_case}) {

        if (${class.name?lower_case} == null) {
            return ResponseEntity.notFound().build();
        }

        ${class.name?lower_case}Service.add(${class.name?lower_case});
        return ResponseEntity.ok().build();
    }

}



