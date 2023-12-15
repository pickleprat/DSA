# Number system coversions 

* ## Base b &rarr; Decimal 
   >Consider a number `(xyz)`<sub>8</sub>  : The formula to figure out convert the number into decimal will be = `x * b ^ 2 + y * b ^ 1 + z * b ^ 0`. 
   
* ## Decimal &rarr; Base b
  > To go from decimal to base b you simply divide the number by base b until you reach and keep the remainder in mind until you reach a number that is less than base b. 

* ## Binary &rarr; Octal
  >Binary and Octal differ by the power of 3. So in this case given a binary number, you may start by grouping the last three numbers of the binary number and then convert them into decimal. 

* ## Octal &rarr; Binary
  >Convert individual numbers to binary numbers and then display them in linear fashion. For example: `(756)`<sub>8</sub> &rarr; `7` = `(111)`<sub>2</sub>, `5` = `(101)`<sub>2</sub>, `6` = `(110)`<sub>2</sub>. Therefore, the final answer = `(111101110)`<sub>2</sub>. 

<br>

# Spittin Fax about Bitwise Logic

* >Bitwise XOR of an entire array will single out the unique number that hasn't been repeated twice. 

* >**The Left Shift Operator :** `<<` Shifts the binary numbers to the left multiplying the orignal number by 2. If we write `a << b` what we are essentially saying is `a x 2 ^ b`. 

* >**The Right Shift Operator  :** `>>` Shifts the binary nmbers to the right dividing the entire number by 2. In this case what you're saying is `a >> b` = `a / 2 ^ b`

* >**The Mask:** Masking is a technique wherein you create a binary number to single out a specific bit of given binary number. I know that sounds to technical so let me explain with an example. Consider the number `10`. Now, the binary representation of this number `10` is `1010`<sub>2</sub>. To access the value of the third bit of this number we create a mask. If we & this binary number with the binary number `(0100)`<sub>2</sub> We will get the value that is stored in the third bit. To create a mask to access the nth bit we say: `1 << (n -1)`. Finally to get our answer: `(1010)` <sub>2</sub> `&` `(1 >> (n - 1)) == 0`

