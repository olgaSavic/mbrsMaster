package ${class.typePackage};

import javax.persistence.*;
import java.util.*;

<#list imports as import>import ${import};
</#list>

@Entity
@Table
${class.visibility} class ${class.name} {

<#list properties as property>
   <#if property.name == "id" >
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    ${property.visibility} ${property.type?cap_first} ${property.name};

   <#elseif property.type == "date" || property.type == "long">
    @Column
    ${property.visibility} ${property.type?cap_first} ${property.name};
   <#elseif property.upper == 1 >
    @Column
    ${property.visibility} ${property.type} ${property.name};

   <#elseif property.upper == -1 >
     ${property.visibility} Set<${property.type}> ${property.name} = new HashSet<${property.type}>();

   <#else>
       <#list 1..property.upper as i>
     ${property.visibility} ${property.type} ${property.name}${i};

       </#list>
   </#if>
</#list>

<#list  class.FMLinkedProperty as property>
    <#if property.upper == -1 && property.oppositeEnd == -1>@ManyToMany<#elseif property.upper == -1 && property.oppositeEnd == 1>@OneToMany<#elseif property.upper == 1 && property.oppositeEnd== -1>@ManyToOne<#else>@OneToOne</#if><#rt>
    <#lt><#if (property.fetch)?? || (property.cascade)?? || (property.mappedBy)?? || (property.optional)?? >(<#rt>
    <#if (property.cascade)??>
        <#lt>cascade = CascadeType.${property.cascade}<#rt>
    </#if>
    <#if (property.fetch)??>
        <#lt><#if (property.cascade)??>, </#if>fetch = FetchType.${property.fetch}<#rt>
    </#if>
    <#if (property.mappedBy)??>
        <#lt><#if (property.cascade)?? || (property.fetch)??>, </#if>mappedBy = "${property.mappedBy}"<#rt>
    </#if>
    <#if (property.optional)??>
        <#lt><#if (property.cascade)?? || (property.fetch)?? || (property.mappedBy)??>, </#if>optional = ${property.optional?c}<#rt>
    </#if>

    <#lt>)</#if>
    ${property.visibility} <#rt>
    <#if property.upper == -1>
        <#lt>Set<<#rt>
    </#if>
    <#lt>${property.type?cap_first}<#rt>
    <#if property.upper == -1>
        <#lt>><#rt>
    </#if>
    <#lt> ${property.name};<#if !property?is_last>${'\n'}</#if>
</#list>

<#list properties as property>
<#if property.upper == 1 >
    <#if property.type == "date" || property.type == "long" >
    public ${property.type?cap_first} get${property.name?cap_first}(){
         return ${property.name};
    }
    <#else>
    public ${property.type} get${property.name?cap_first}(){
    return ${property.name};
    }

    </#if>
    <#if property.type == "date" || property.type == "long" >
    public void set${property.name?cap_first}(${property.type?cap_first} ${property.name}){
         this.${property.name} = ${property.name};
    }
    <#else>
       public void set${property.name?cap_first}(${property.type} ${property.name}){
         this.${property.name} = ${property.name};
    }
    </#if>

<#elseif property.upper == -1 >
    public Set<${property.type}> get${property.name?cap_first}(){
         return ${property.name};
    }

    public void set${property.name?cap_first}( Set<${property.type}> ${property.name}){
         this.${property.name} = ${property.name};
    }

<#else>
    <#list 1..property.upper as i>
    public ${property.type} get${property.name?cap_first}${i}(){
         return ${property.name}${i};
    }

    public void set${property.name?cap_first}${i}(${property.type} ${property.name}${i}){
         this.${property.name}${i} = ${property.name}${i};
    }

    </#list>
</#if>
</#list>

<#list  class.FMLinkedProperty as property>
    <#if property.upper == 1 && property.oppositeEnd== -1>
    public ${property.type} get${property.name?cap_first}(){
        return ${property.name};
    }
    public void set${property.name?cap_first}(${property.type} ${property.name}){
        this.${property.name} = ${property.name};
    }
    <#elseif property.upper == -1>

    public Set<${property.type}> get${property.name?cap_first}(){
        return ${property.name};
    }
    public void set${property.name?cap_first}(Set<${property.type}> ${property.name}){
        this.${property.name} = ${property.name};
    }
    </#if>
</#list>

}
