
(ns time.schedule
    (:require [iso.time.convert :as convert]
              [tea-time.core    :as tea-time.core]))


;; -- aphyr/tea-time ----------------------------------------------------------
;; ----------------------------------------------------------------------------

;https://github.com/aphyr/tea-time
(tea-time.core/start!)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-timeout!
  ; @param (function) f
  ; @param (ms) timeout
  ;
  ; @usage
  ; (set-timeout! #(println "3 sec") 3000)
  ;
  ; @return (tea_time.core.Once object)
  [f timeout]
  (tea-time.core/after! (convert/ms->s timeout) f))

(defn set-interval!
  ; @param (function) f
  ; @param (ms) interval
  ;
  ; @usage
  ; (set-interval! #(println "3 sec") 3000)
  ;
  ; @return (tea_time.core.Every object)
  [f interval]
  (tea-time.core/every! (convert/ms->s interval) 0 f))

(defn clear-interval!
  ; @param (integer) interval-id
  ;
  ; @return (nil)
  [interval-id])
  ; TODO
