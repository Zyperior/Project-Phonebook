+-- src
    +-- phonebook
        +-- base
        +-- gui
        +-- run
        +-- storage


ROADMAP

|       GUI                    			    |CLASS THAT MAKES ADR BK OBJ                  |CLASS THAT SAVES DATA
| enter username       	           	            |//can be replaced with factory call  	  |saveFile(STRING,LIST)
|   click ok(calls factory/constructor with STRING)->Constructor(string s)      		  |returns nothing
|					   	    |this.list = calls öyvins retrieve list(s)}   |
|					            |this.username = s;	                          |loadFile(STRING)
|						    |//method for saving                          |returns LIST
|						    | calls öyvins save method(username,list)     |//list can be full or empty
