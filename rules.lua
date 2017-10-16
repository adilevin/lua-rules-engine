return {

  {  ["pred"] = function()
       return age<50
      end,
      ["action"] = "accept",
      ["text"] = "IF age<50 THEN accept" },

  {  ["pred"] = function()
       return height>=180
      end,
      ["action"] = "reject",
      ["text"] = "IF height>=180 THEN reject" },

}