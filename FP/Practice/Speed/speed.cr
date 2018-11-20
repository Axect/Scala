# a = (1..1_000_000).to_a

# i = 0
# until i == 1_000_000
#     a[i] = a[i]**2
#     i += 1
# end

# s = 0
# j = 0
# until j == 1_000_000
#     s += a[j]
#     j += 1
# end

# puts s

a = (1..10).to_a

i = 0
s = 0
until i == 10
    s += a[i]
    i += 1
end
puts s