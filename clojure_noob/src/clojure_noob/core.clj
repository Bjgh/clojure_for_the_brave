;; ns - defines namespace
(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little tea pot")
  (defn train
  []
  (println "Choo choo!"))
)
;; Basic evaluation - Clojure treats white space as the separator to
;; to operands .  , are also treated as white space 

;; adds n numbers
(+ 1 2 3)
;; concatenates three strings 
(str "it was the most " " glorious of days " " said the hard working PhD student " )

;; Control flow

;; three basic control flow operators if, do, when - there are others

;; (if boolen-form
;;     then-form
;;     optional-else-form)
(if true
  "By jove, the warlocks are coming "
  "This is noo good said pedro ")
(if false
  "By jove, the warlocks are coming "
  "This is noo good said pedro ")

 
 ;; the do operatory lets you wrap up multiple forms in parentheses
( if true 
  (do (println "Success! ")
       " By jove, the warlokcs are comming ")
  (do (println " Failure! ")
      "This is noo good said pedro "))

;; when statement a combination of if and do statements, but with
;; no else

(when true
  (println " Success!")
  "Adra cadabra")

;; Truthness 

;; There exists true, false and to represent none, use nil
(nil? 1)
; false
(nil? nil)
; true 

;; Both nil and false are used to represent logical false
;; all other values are logically true [], 0, "hjfsfjh43 r34"  etc

;; Equality is given by = in clojre i.e

(= 1 1)
; true

(= 1 2)
; false

;; Boolean operators : or , and 

;*  or * returns either the first or last truthy value

(or false nil :large_I_mean :why_cant_i_just)



(or  ( = 0 1) (= "yes" "no"))

;* and * returns the first false value or, if no values are false, 
; the last truth value

(and :free_wifi :hot_coffee)

(and :feelin_super_cool nil false)

;; Naming values with def , to bind a name to a value

(def failed-names
  ["Larry Potter" "Doreen the explorer" "Dim Carey"])

; As in clojure we are binding and not assigning, the language
; is not typically suited to reassigning variables 
; in, python for instance
; to get around this we can do things such as:
(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOOOOOOMED!")))
; (error-message :mild)
; NOTE: defn - define function

;; In python we'd write:
;       severity = mild, error_message = "OH GOD IT IS A DISATER.."
;       if severity == mild:
;           error_message = error_message + "MILdly.."
;       else:
;            error_message = error_message + "DOOMED"


;; Data structures : All data structures in Clojure are immutable


;; Maps - similar to dictionaires or hashes in other languages
;  They associate some value, with some other value. 

; empty map
{}
{:first-name "Bradley"
:last-name "Gram-Hansem"}

{"string-key" +}

{:name {:first "Bradley" :middle "Jake" :last "Gram-Hansen"}}

;; Hash maps

(hash-map :a 1 :b 2)

; To loop vslurd in maps and hashes , use get function 

(get {:a 0 :b 1} :b)
(get (get {:a 0 :b {:c "ho hum"}} :b) :c) 
; "ho hum"

; Rather than use two get statements we can use get-in

(get-in {:a 0 :b {:c "ho hum"}} [:b :c])
; "ho hum"

; You can alternatively just use the name , like key-value pairs

({:name "The human coffeepot"} :name)

;; Keywords, :a :_? start with :

(:a {:a 1 :b 2 :c 3})
; equivilent 
(get {:a 1 :b 2 :c 3} :a)

;; Its a 0-indexed collection
(get [1 2 3] 1) ; get element from index 1

(get ["a" {:name "Pugsley Winterbottom"} "c"] 1)

; vector elements can be of any type
; we can also create vectors, with vector function
(vector "creepy" "full" "moon")

; to append to a collection, vector we can use conj function
(conj [1 2 3] 4)
; [1 2 3 4]

;; Lists 
; You cant retrive list elements with get

'(1 2 3 4)

; To retrive the nth element , you can use the nth function

(nth '(:a :b :c) 0)

; nth is much slower than get

; again list values, like vectors, can have any type
(list 1 "two" {3 4})

(conj '(1 2 3) 4)
; now prepends (4 1 2 3)

;lists are good when needing to append the beginning of a sequence, 
; vectors are good when needing to append the end of a sequence

;; Sets

; Sets are collections of unique values. Two types of sets: sorted sets
                                        ;                   hash sets
; hash-sets
#{"kurt vonnegut" 20 :icicle}
; or
(hash-set 1 1 2 2) 

; sets can also be created from existing vectors and lists via the
; set function 

(set [3 3 3 4 4])

; check for membership as follows:
(contains? #{:a :b} :a)
(contains? #{:a :b} 3)

(contains? #{nil} nil)

; or, using keywords

(:a #{:a :b})

;or  

(get  #{:a :b} :a)

(get #{:a :b} "kurt vonnegut")
; nil  (not false , but nil is a falsey. contains? is better,
; especially if you are testing set membership

;; Functions

((and (= 1 1) +) 1 2 3)
; 6 

; or
((first [+ 0]) 1 2 3)

; Note: Fntions can take expressions as arguments, including other
;       functions. Functions that can either tak a function as an
;       argument or retun a function are called: Higher order functions

; i.e. take the map fn (not data struture)

( inc 1.1) ; increments by 1

(map inc [0 1 2 3]) ; increments all elements by 1 , returns list NOT vec

; So what we have here, in paticular in Clojure, is that we can 
; create functions that generalise over processes. map allows you
; to generilise the process of transforming a collection by applying
; a function -  any function  - over any collection. 

; Clojure evaluates all function arguments recursively before passing them
; to the function

; Here is an example:

(+ (inc 199) (/ 100 (- 8 5)))
; (+ 200 (/ 100 (- 8 5)))
; (+ 200 (/ 100  3))
; (+ 200 100/3)
; 700/3

; Function calls, Macro calls and Special forms

; special form, unlike function calls, don't always evaluate all
; of their operands, i.e.

(if good-mood
  (tweet walking-on-sunshine lyrics)
  (tweet nothing-else-matters lyrics))

; Macros are similar to special forms, in that they evaluate their
; opterands differently from fucntion calls and theyn also can;t be passed
; as arguments to functions, like special forms


;; Defining functions

; Five parts
;  defn 
;      function name
;      A docstring describing the function
;      [arguments] 
;      Function body

(defn too-enthusiastic
  " Return a cheer that might be a bit too entuasiastic "
  [name]
  (str "OH. MY. GOD! " name " YOU ARE AMAZING")
)
(too-enthusiastic "zelda")

;To see the doc-string of a function : (doc fn-name) i.e (doc +)

;An example of a multi-arity function 

(defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
     (str "I " chop-type " chop " name "! Take that!"))
  ([name]
     (x-chop name "karate")))

; Will call karate as defualt for the second parameter if only one
; parameter is given. 

; Clojure allows one to define variable-arity functions by includeing a 
; rest parameter, as in "put the rest of these arguments in a list with the following name" 

; the rest parameter is indicated with &  , i.e

(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper "!!!"))

(defn codger
   [& whippersnappers]
  (map codger-communication whippersnappers))

(codger "Billy" "Anne" "Steve" "WIll")

; you can mix rest and normal parameters, but rest parameters will
; always go last.

(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my favorite things: "
       (clojure.string/join ", " things)))

(favorite-things "Doreen" "gum" "shoes" "kara-te")

;; Destructuring 

;Destructuring lets you concisely bind names to values within a collection

(defn my-fir
  [[first-thing]] ;first thing is within a vector
  first-thing)

(my-fir ["ove" "bik" "war"])

(defn chooser 
  [[ first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "All other choices : " (clojure.string/join "," unimportant-choices))))

(chooser ["jam" "nutella" "bike" "running" "mountains"])

; we can do the same to maps also

(defn ann-tres-loc
  [{lat :lat lng :lng}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure long: " lng))
)

(ann-tres-loc {:lat 28.2342 :lng 34.432})

;equivilently we could write:

(defn ann-tres-loc
  [{:key [lat lng]}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure long: " lng))
)

;; Anonymous functions

; In clojure fn do not need to have names

;(fn [param-list]
;  function body)

(map (fn [name] (str "Hello, " name))
     ["Bradley" "Steve"]) 

((fn [x] (* x 3)) 8)

; You can name anonymous functions as follows:
(def my-fun (fn [x] (* x 4)))
(my-fun 24.24234234)

; in a more compact way we could write:
#(* % 4)


;applied
(#(* % 4) 32)

(map #(str "Hi, " %)
     ["Bradley" "Steve"])

;; Returning functions

; functions can return other functions, the returned
; functions are closures. 
; A closure can access all the variables that were in scope when the function was created

(defn inc-maker
"Create a custom incrementer"
 [inc-by]
 #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 2)

;; The shires next top model 

(def asym-hobbit-bp [{:name "head" :size 3 }
                      {:name "left-eye" :size 1 }
                      {:name "left-ear" :size 1 }
                      {:name "mouth" :size 1 }
                      {:name "nose" :size 1 }
                      {:name "neck" :size 2 }
                      {:name "left-shoulder" :size 3 }
                      {:name "left-upper-arm" :size 3 }
                      {:name "chest" :size 10 }
                      {:name "back" :size 10}
                      {:name "left-forearm" :size 3 }
                      {:name "abdomen" :size 6 }
                      {:name "left-kidney" :size 1 }
                      {:name "left-hand" :size 2 }
                      {:name "left knee" :size 2 }]
)

; creating the right hand side
(defn match-part
  [part]
  {:name (clojure.string/replace(:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmet-bp
  "Expects a seq of maps that have a :name and a :size"
  [asym-bp]
  (loop [rem-asym-parts asym-bp final-bp []]
    (if (empty? rem-asym-parts)
      final-bp
      (let [[part & rem] rem-asym-parts]
            (recur rem
                   (into final-bp
                         (set [part (match-part part)])))))))

(symmet-bp asym-hobbit-bp)
