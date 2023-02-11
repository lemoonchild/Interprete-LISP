
(
    defun fib (n)

        (if (< n 2)
            n
            (+ (fib (- n 1)) (fib (- n 2)))))

    (print (fib 12)

) 


(
    defun fact (n)
        (if (= n 1)
            1
            (* n (fact (- n 1)))))

    (print (fact 5)

) 
