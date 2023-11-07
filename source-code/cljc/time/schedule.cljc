
(ns time.schedule
    (:require #?(:clj [tea-time.core])
              [time.convert :as convert]))

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
  #?(:clj  (tea-time.core/after! (convert/ms->s timeout) f)
     :cljs (.setTimeout js/window f timeout)))

(defn set-interval!
  ; @param (function) f
  ; @param (ms) interval
  ;
  ; @usage
  ; (set-interval! #(println "3 sec") 3000)
  ;
  ; @return (clj: tea_time.core.Every object, cljs: integer)
  [f interval]
  #?(:clj  (tea-time.core/every! (convert/ms->s interval) 0 f)
     :cljs (.setInterval js/window f interval)))

(defn clear-interval!
  ; @param (integer) interval-id
  ;
  ; @return (clj: ?, cljs: integer)
  [interval-id]
  #?(:cljs (.clearInterval js/window interval-id)))
