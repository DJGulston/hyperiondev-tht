"use strict";
/**
 * Encrypts any message using a Caesar Cipher with any given shift value.
 * @param message string - The message that will be encrypted.
 * @param shift number - The number of positions to shift right in the alphabet
 * from a given character in the message.
 * @returns An encrypted Caesar Cipher string.
 */
const caesar_cipher = (message, shift) => {
    // Alphabet will be referenced to determine what each character in
    // the message will be replaced with based on the shift value.
    const alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    // This will store the value of the encrypted message/text.
    let encodedText = '';
    // If the character shift is larger than 26, we use modulus to reduce
    // the number shifts down to its necessary number of shifts.
    if (shift > 26) {
        shift = shift % 26;
    }
    for (let i = 0; i < message.length; i++) {
        // Checks if the current character i is a valid alphabet character
        if (alphabet.indexOf(message[i]) !== -1) {
            // Finds the alphabet index of the current character i.
            const alphabetIndex = alphabet.indexOf((message[i]).toUpperCase());
            // Checks if the alphabet index plus the shift is in the alphabet range
            if (alphabet[alphabetIndex + shift]) {
                // Append shifted character to encodedText
                encodedText += alphabet[alphabetIndex + shift];
            }
            else {
                // Adjust Alphabet Index by 26 Characters if the alphabet index is out
                // of range, and appends the adjusted shifted character to the encodedText.
                encodedText += alphabet[alphabetIndex + shift - 26];
            }
        }
        else {
            // Appends original character to encodedText if the character is not part
            // of the alphabet.
            encodedText += message[i];
        }
    }
    return encodedText;
};
//printing the output to terminal to test for correct output
//should print THE QUICK BROWN DOG JUMPED OVER THE LAZY FOX.
console.log(caesar_cipher('GUR DHVPX OEBJA QBT WHZCRQ BIRE GUR YNML SBK.', 39));
