# Math-Logic-Prover
A modified version of my Pemdas calculator program but with mathematical logic

The program accepts string input and outputs a boolean value

#Sample inputs
```
Prove p ^ q

where:        
    p is true 
    q is false


RESULT: FALSE
```

```
Prove p^q = ~(pvq)

where:        
    p is true 
    q is false


RESULT: TRUE  
```

```
Prove (p v q)->(p^q) = (p ^q) <-> ~q

where:        
    p is true 
    q is false


RESULT: TRUE 
```
