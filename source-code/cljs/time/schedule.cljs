
;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns time.schedule)



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-timeout!
  ; @param (function) f
  ; @param (ms) timeout
  ;
  ; @usage
  ;  (time/set-timeout! #(println "3 sec") 3000)
  ;
  ; @return (integer)
  [f timeout]
  (.setTimeout js/window f timeout))

(defn set-interval!
  ; @param (function) f
  ; @param (ms) interval
  ;
  ; @usage
  ;  (time/set-interval! #(println "3 sec") 3000)
  ;
  ; @return (integer)
  [f interval]
  (.setInterval js/window f interval))

(defn clear-interval!
  ; @param (integer) interval-id
  ;
  ; @return (nil)
  [interval-id]
  (.clearInterval js/window interval-id))
