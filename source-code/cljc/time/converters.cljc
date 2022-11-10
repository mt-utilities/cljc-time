
;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns time.converters
    (:require [format.api      :as format]
              [mid-fruits.math :as math]))



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn ms->s [n] (/ n 1000))
(defn ms->m [n] (/ n 60000))
(defn ms->h [n] (/ n 3600000))
(defn ms->D [n] (/ n 86400000))
(defn ms->W [n] (/ n 604800000))
(defn s->ms [n] (* n 1000))
(defn s->m  [n] (/ n 60))
(defn s->h  [n] (/ n 3600))
(defn s->D  [n] (/ n 86400))
(defn s->W  [n] (/ n 604800))
(defn m->ms [n] (* n 60000))
(defn m->s  [n] (* n 60))
(defn m->h  [n] (/ n 60))
(defn m->D  [n] (/ n 1440))
(defn m->W  [n] (/ n 10800))
(defn h->ms [n] (* n 3600000))
(defn h->s  [n] (* n 3600))
(defn h->m  [n] (* n 60))
(defn h->D  [n] (/ n 24))
(defn h->W  [n] (/ n 168))



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn ms->time
  ; @param (float, integer or string) n
  ; @param (keyword)(opt) format
  ;  :hhmmssmmm, :hhmmss
  ;
  ; @example
  ;  (time/ms->time 260000)
  ;  =>
  ;  "00:04:20.000"
  ;
  ; @example
  ;  (time/ms->time 260000.123)
  ;  =>
  ;  "00:04:20.000"
  ;
  ; @example
  ;  (time/ms->time 260000 :hhmmss)
  ;  =>
  ;  "00:04:20"
  ;
  ; @return (string)
  ([n]
   (ms->time n :hhmmssmmm))

  ([n format]
   (if n (let [hours        (format/leading-zeros      (-> n ms->h math/floor)       2)
               minutes      (format/leading-zeros (rem (-> n ms->m math/floor) 60)   2)
               seconds      (format/leading-zeros (rem (-> n ms->s math/floor) 60)   2)
               milliseconds (format/leading-zeros (rem (-> n       math/floor) 1000) 3)]
              (case format :hhmmssmmm (str hours ":" minutes ":" seconds "." milliseconds)
                           :hhmmss    (str hours ":" minutes ":" seconds))))))
