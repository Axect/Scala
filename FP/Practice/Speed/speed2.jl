function main()::Int64
    l = Int64(1E+08)
    A = 1:l
    s = foldl(+, 0, A)
    return s
end

@time main()
