package ${class.typePackage};
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.${class.name}Service;
<#list class.FMLinkedProperty as property>
    <#if property.upper == 1 && property.oppositeEnd== -1>
import uns.ftn.mbrs.service.${property.name?cap_first}Service;
    </#if>
</#list>

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uns.ftn.mbrs.model.*;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
public class ${class.name?cap_first}Controller {

    @Autowired
    private ${class.name?cap_first}Service ${class.name?lower_case}Service;

<#list class.FMLinkedProperty as property>
    <#if property.upper == 1 && property.oppositeEnd== -1>
    @Autowired
    private ${property.name?cap_first}Service ${property.name?lower_case}Service;
    </#if>
</#list>

    @GetMapping(value = "all${class.name}s")
    public String getAll${class.name}(Model model) {

        List<${class.name?cap_first}> all${class.name?cap_first}s = this.${class.name?lower_case}Service.getAll();
        model.addAttribute("${class.name?lower_case}s", all${class.name?cap_first}s);
        return "${class.name?cap_first}List";
    }

    @GetMapping(value = "${class.name?lower_case}/new")
    public String new${class.name}(Model model) {
        model.addAttribute("${class.name?lower_case}", new ${class.name?cap_first}());
    <#list class.FMLinkedProperty as property>
    <#if property.upper == 1 && property.oppositeEnd== -1>
        List<${property.name?cap_first}> ${property.name?lower_case}s = ${property.name?lower_case}Service.getAll();
        model.addAttribute("${property.name?lower_case}s", ${property.name?lower_case}s);
    </#if>
    </#list>
        return "${class.name?cap_first}Form";
    }

    @GetMapping(value = "${class.name?lower_case}/{id}")
    public String show${class.name}Details (@PathVariable("id") Long id, Model model) {
        model.addAttribute("${class.name?lower_case}", ${class.name?lower_case}Service.getOne(id).orElse(null));
        return "${class.name?cap_first}Details";
    }

    /*
    @GetMapping(value = "one${class.name}")
    public ResponseEntity getOne${class.name}(@RequestParam Long id) {

        Optional<${class.name?cap_first}> ${class.name?lower_case} = ${class.name?lower_case}Service.getOne(id);
        if (${class.name?lower_case} == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(${class.name?lower_case}, HttpStatus.OK);
    }
    */


    @GetMapping("${class.name?lower_case}/delete")
    public String delete${class.name?cap_first}(@RequestParam("id") String id) {
        ${class.name?lower_case}Service.delete(Long.parseLong(id));
        return "${class.name?cap_first}List";
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
    public String add${class.name}(@ModelAttribute ${class.name?cap_first} ${class.name?lower_case}) {

        ${class.name?lower_case}Service.add(${class.name?lower_case});
        return "${class.name?cap_first}List";
    }






}



