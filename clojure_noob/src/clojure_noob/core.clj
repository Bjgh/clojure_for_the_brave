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

; or returns either the first or last truthy value

(or false nil :large_I_mean :why_cant_i_just)



(or  ( = 0 1) (= "yes" "no"))

; and returns the first false value or, if no values are false, 
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
