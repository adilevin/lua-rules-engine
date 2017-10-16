age = 60
height = 80
weight = 40

print("\nage = " .. age)
print("height = " .. height)
print("weight = " .. weight)

rules = require("rules")

print("\nInvoking rules")

decision = "neutral"
reason = ""
for n, r in ipairs(rules) do
   print("invoking rule # " .. n .. ": " .. r["text"])
   if r["pred"]() then
      decision = r["action"]
      reason = r["text"]
      break
   end
end

print("Done\n")

print("Decision: " .. decision)
if decision~="neutral" then
    print("Reason: " .. reason)
end