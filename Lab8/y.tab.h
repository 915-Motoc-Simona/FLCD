
/* A Bison parser, made by GNU Bison 2.4.1.  */

/* Skeleton interface for Bison's Yacc-like parsers in C
   
      Copyright (C) 1984, 1989, 1990, 2000, 2001, 2002, 2003, 2004, 2005, 2006
   Free Software Foundation, Inc.
   
   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.
   
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
   
   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.
   
   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */


/* Tokens.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
   /* Put the tokens into the symbol table, so that GDB and other debuggers
      know about them.  */
   enum yytokentype {
     ARRAY = 258,
     OF = 259,
     VAR = 260,
     IF = 261,
     WRITE = 262,
     READINT = 263,
     READSTRING = 264,
     READCHAR = 265,
     ELSE = 266,
     WHILE = 267,
     RETURN = 268,
     IDENTIFIER = 269,
     INTCONSTANT = 270,
     STRINGCONSTANT = 271,
     CHARCONSTANT = 272,
     PLUS = 273,
     MINUS = 274,
     TIMES = 275,
     DIV = 276,
     MOD = 277,
     EQ = 278,
     BIGGER = 279,
     BIGGEREQ = 280,
     LESS = 281,
     LESSEQ = 282,
     EQQ = 283,
     NEQ = 284,
     AND = 285,
     OR = 286,
     SEMICOLON = 287,
     OPEN_CURLY_BRACKET = 288,
     CLOSE_CURLY_BRACKET = 289,
     OPEN_ROUND_BRACKET = 290,
     CLOSE_ROUND_BRACKET = 291,
     OPEN_SQUARE_BRACKET = 292,
     CLOSE_SQUARE_BRACKET = 293,
     COMMA = 294,
     INT = 295,
     CHAR = 296
   };
#endif
/* Tokens.  */
#define ARRAY 258
#define OF 259
#define VAR 260
#define IF 261
#define WRITE 262
#define READINT 263
#define READSTRING 264
#define READCHAR 265
#define ELSE 266
#define WHILE 267
#define RETURN 268
#define IDENTIFIER 269
#define INTCONSTANT 270
#define STRINGCONSTANT 271
#define CHARCONSTANT 272
#define PLUS 273
#define MINUS 274
#define TIMES 275
#define DIV 276
#define MOD 277
#define EQ 278
#define BIGGER 279
#define BIGGEREQ 280
#define LESS 281
#define LESSEQ 282
#define EQQ 283
#define NEQ 284
#define AND 285
#define OR 286
#define SEMICOLON 287
#define OPEN_CURLY_BRACKET 288
#define CLOSE_CURLY_BRACKET 289
#define OPEN_ROUND_BRACKET 290
#define CLOSE_ROUND_BRACKET 291
#define OPEN_SQUARE_BRACKET 292
#define CLOSE_SQUARE_BRACKET 293
#define COMMA 294
#define INT 295
#define CHAR 296




#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef int YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define yystype YYSTYPE /* obsolescent; will be withdrawn */
# define YYSTYPE_IS_DECLARED 1
#endif

extern YYSTYPE yylval;


