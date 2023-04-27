# Section A: Option 4 Code Review

## Positive aspects of the submission

The logic of your solution works perfectly. When entering "GUR DHVPX OEBJA QBT WHZCRQ BIRE GUR YNML SBK." as your string argument and 39 as your shift argument in your caesar_cipher function, it returns the correct output: "THE QUICK BROWN DOG JUMPED OVER THE LAZY FOX."

It is good that you have left comments in your code as it provides context as to what your code is doing.

## Aspects of the submission that could be improved

There is no need for an Alphabet type as you have created on line 2. As such, you can change your alphabet variable on line 7 from type Alphabet to type string and you can remove the Alphabet type on line 2, since your solution reads the alphabet variable as a string anyway.

The logic in your solution works well, however, you can also reduce the number of lines of code by using a for-loop instead of a while-loop on line 19. As a result, you will be able to delete lines 18, 42 and 43.

On line 15, it is recommended that the closing bracket for your IF statement is placed on the next line to make your code more readable.

It is also recommended to add a new line space after line 18 to make the code more readable.

On line 51, the incorrect function was used to display your result to the console. Instead of print(), you should use console.log().

As mentioned, your comments do provide some context as to what your code is doing, however, I do recommend that you make your comments a bit more descriptive in some areas, as some comments may be a bit redundant. For example, on line 6 where you commented 'Alphabet', you can instead describe the purpose of the alphabet variable. You can also add a JSDoc Reference comment for your function on line 4. In VSCode, if you type /** and hit enter, and that will autofill your JSDoc Reference comment, and you can add a description for your function. Here is a source to read more about JSDoc Reference comments:

- [https://www.typescriptlang.org/docs/handbook/jsdoc-supported-types.html](https://www.typescriptlang.org/docs/handbook/jsdoc-supported-types.html)

On line 5, where you declared your caesar_cipher function, there are a couple of syntax and coding convention issues that need a quick fix:

- The caesar_cipher arrow function was declared incorrectly in terms of its syntax. To fix the syntax of the function declaration, here is a source that shows you how to declare an arrow function in TypeScript:

  - [https://www.tutorialsteacher.com/typescript/arrow-function](https://www.tutorialsteacher.com/typescript/arrow-function).

- The return type of the caesar_cipher function has not been declared. So, for example, if your function is supposed to return a string, you have to declare that the return type is a string. Or, for example, if it returns nothing, and probably prints something to the console instead, the return type of the function should be declared as void. You can read more about return types here:

  - [https://www.educba.com/typescript-function-return-type/](https://www.educba.com/typescript-function-return-type/).

- It is not recommended to name variables to something like 'string', as 'string' is a reserved keyword in TypeScript. I recommend you rename the first parameter from 'string' to something more descriptive like 'message', 'originalText' or something similar, so it makes it easier for new readers of your code to follow along. Just remember to also change the parameter names on lines 19, 21, 23 and 39. Here are some sources that go into a bit more detail about naming conventions:

  - [https://curc.readthedocs.io/en/latest/programming/coding-best-practices.html](https://curc.readthedocs.io/en/latest/programming/coding-best-practices.html)
  - [https://google.github.io/styleguide/tsguide.html#descriptive-names](https://google.github.io/styleguide/tsguide.html#descriptive-names)

- Note that you do not need to make use of generics in your caesar_cipher function. The first parameter will only ever need to be a string, so you can declare that first parameter's type as 'string' instead of the generic type 'T'. Another thing to note is that there was a syntax issue when the generic arrow function was declared. In the future, if you need to declare an arrow function that uses generics, here is a source showing you how to do exactly that:

  - [https://timmousk.com/blog/typescript-arrow-function-generic/](https://timmousk.com/blog/typescript-arrow-function-generic/).

- The naming convention for your second parameter is good. The name 'shift' is descriptive and indicates the purpose of the parameter. The type for the 'shift' parameter, however, just needs to be changed from a string to a number, since 'shift' can only ever be numerical.

## Overall feedback

The logic of your caesar_cipher function was executed perfectly. However, some syntax and coding convention issues just need to be addressed. Always make sure to test and run your code to see if your program is working as intended.
