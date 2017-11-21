function main()::Int64
    s = Int64(0)
    l = Int64(1E+07)
    A = collect(1:1:l)
    for i = 1:length(A)
        s += A[i]
    end
    return s
end

@time main()
