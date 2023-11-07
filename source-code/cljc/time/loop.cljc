
(ns time.loop
    (:require [time.schedule :as schedule]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn reduce-interval
  ; @description
  ; Iterates over the given 'coll' collection and applies the given 'f' function on each item
  ; while taking an 'interval' long pause between them.
  ;
  ; @param (function) f
  ; @param (collection) coll
  ; @param (integer) interval
  ;
  ; @example
  ; (reduce-interval my-function [:a :b :c] 500)
  ; =>
  ; (set-timeout! #(my-function :a)    0)
  ; (set-timeout! #(my-function :b)  500)
  ; (set-timeout! #(my-function :c) 1000)
  ;
  ; @return (*)
  [f coll interval]
  (letfn [(reduce-interval-f [lap item]
                             (schedule/set-timeout! #(f item)
                                                     (* lap interval))
                             (inc lap))]
         (reduce reduce-interval-f 0 coll)))
