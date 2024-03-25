
(ns time.schedule
    #?(:clj  (:require [tea-time.core]
                       [time.convert :as convert])
       :cljs (:require [time.convert :as convert])))

;; -- aphyr/tea-time ----------------------------------------------------------
;; ----------------------------------------------------------------------------

;https://github.com/aphyr/tea-time
#?(:clj (tea-time.core/start!))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-timeout!
  ; @param (function) f
  ; @param (ms) timeout
  ;
  ; @usage
  ; (set-timeout! #(println "3 sec") 3000)
  ;
  ; @return (clj: tea_time.core.Once object, cljs: integer)
  [f timeout]
  ; CLJS: In case the given 'timeout' value is 0, there is no need to apply the given 'f' function asynchron and setting up a timeout with 0ms value.
  #?(:clj  (if (-> timeout zero?) (f) (if (-> timeout number?) (tea-time.core/after! (convert/ms->s timeout) f)))
     :cljs (if (-> timeout zero?) (f) (if (-> timeout number?) (.setTimeout js/window f timeout)))))

(defn set-interval!
  ; @param (function) f
  ; @param (ms) interval
  ;
  ; @usage
  ; (set-interval! #(println "3 sec") 3000)
  ;
  ; @return (clj: tea_time.core.Every object, cljs: integer)
  [f interval]
  #?(:clj  (if (-> interval number?) (tea-time.core/every! (convert/ms->s interval) 0 f))
     :cljs (if (-> interval number?) (.setInterval js/window f interval))))

(defn clear-interval!
  ; @param (integer) interval-id
  ;
  ; @usage
  ; (let [interval-id (set-interval! #(println "3 sec") 3000)]
  ;      (clear-interval! interval-id))
  ;
  ; @return (clj: ?, cljs: integer)
  [interval-id]
  #?(:cljs (.clearInterval js/window interval-id)))
