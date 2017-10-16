return {
<#list conditionals as cond>

  {  ["pred"] = function()
       return ${cond.predicate?no_esc}
      end,
      ["action"] = "${cond.action}",
      ["text"] = "IF ${cond.predicate?no_esc} THEN ${cond.action}" },
</#list>

}