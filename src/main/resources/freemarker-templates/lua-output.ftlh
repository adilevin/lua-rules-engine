-- This code was auto-generated using ANTLR4

return {
<#list conditionals as cond>

  { ["pred"] = function(person)
      return (person.${cond.predicate.measurement} ${cond.predicate.comparator?no_esc} ${cond.predicate.value})
    end,
    ["action"] = "${cond.action}",
    ["text"] = "if ${cond.predicate.measurement} ${cond.predicate.comparator?no_esc} ${cond.predicate.value} then ${cond.action}" },
</#list>

}