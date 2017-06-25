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
(+ 1 (* 2 3) 4)

(map (comp record first)
     (d/q '[:find ?post
            :in $ ?search
            :where
            [(fulltext $ :post/content ?search)
             [[?post ?content]]]]
          (db/db)
          (:q params)))
