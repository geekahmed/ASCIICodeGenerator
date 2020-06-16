## ASCII Code Generator Based on Parity Bit

**Introduction**

Parity bits are used during information transfer as a form of error checking. When old modems transmitted data over a network or communications device, the data was encoded into a series of so-called bits and zeros (modern modems send information in packets and check for errors in different ways, therefore a parity bit is unnecessary). Only two possible states, 0 (off) or 1 (on), can be described with a single bit. Thus, it takes several bits to describe a letter or number. A total of seven bits are used to describe the set of ASCII characters, including the letters and numbers which make up this document.

For example, the letter "A" has ASCII code 65 which is 1000001 in binary. Note that each binary digit corresponds to a power of two, and 65, which is two to sixth power plus two to zero power, has only one in its binary representation 's sixth and zeroth columns. The letter C has the binary sequence 1000011, having code value 67.

Since noise or electrical interference can sometimes interfere with data transmission, it's useful to have some way to easily detect information errors as they are exchanged. One way to do this is to add an 8th bit to transmitted characters, called a parity bit. The parity bit is selected in such a way that all properly transmitted characters would either have an even or uncommon number of ones. Thus, if a zero for letter A, which produces 01000001, were placed at the start of the code, one would be placed before the code for C, producing 11000011.

The prefixes shown here produce binary codes with even numbers (and zeros), and thus the added bit is called a parity bit even. It might also be possible to choose the leading ones and zeros to always produce odd numbers of ones and zeros and this scheme is called odd parity. E7, which uses one even parity bit and seven data bits, and N8, which implies no parity bit and the use of all eight bits for data transmission, are common settings in communications programmes.

Using the wrong parity setting will generate screens full of garbage characters in a communications programme. If this happens, check to see what parity settings expected of the computer you are connecting to. If this information is not available, try connecting to a different parity setting and see if it produces legible text.

-----------------

**Project Report:** [Find it Here](Project-Report/ASCII-Code-Generator-Report.pdf)
