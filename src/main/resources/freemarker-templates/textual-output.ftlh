<#list conditionals as cond>
- IF ${cond.predicate?no_esc} THEN ${cond.action}
</#list>

