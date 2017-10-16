person = { ["age"] = 60, ["height"] = 280, ["weight"] = 40}

print("\nage = " .. person.age)
print("height = " .. person.height)
print("weight = " .. person.weight)

rules = require("rules")

print("\nInvoking rules")

decision = "neutral"
reason = ""
for n, r in ipairs(rules) do
   print("invoking rule # " .. n .. ": " .. r.text)
   if r.pred(person) then
      decision = r.action
      reason = r.text
      break
   end
end

print("Done\n")

print("Decision: " .. decision)
if decision~="neutral" then
    print("Reason: " .. reason)
end