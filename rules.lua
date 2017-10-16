-- This code was auto-generated using ANTLR4

return {

  { ["pred"] = function(person)
      return (person.age < 50)
    end,
    ["action"] = "accept",
    ["text"] = "if age < 50 then accept" },

  { ["pred"] = function(person)
      return (person.height >= 180)
    end,
    ["action"] = "reject",
    ["text"] = "if height >= 180 then reject" },

  { ["pred"] = function(person)
      return (person.weight == 40)
    end,
    ["action"] = "accept",
    ["text"] = "if weight == 40 then accept" },

}