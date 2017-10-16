age = 10
height = 80
weight = 40

rules = require("rules")

decision = "neutral"
reason = ""
for n, r in ipairs(rules) do
   if r["pred"]() then
      decision = r["action"]
      reason = r["text"]
      break
   end
end

print("Decision: ", decision)
print("Reason: ", reason)