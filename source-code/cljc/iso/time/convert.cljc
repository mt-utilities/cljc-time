
(ns iso.time.convert
    (:require [format.api :as format]
              [math.api   :as math]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn ms->s
  ; @param (ms) n
  ;
  ; @usage
  ; (ms->s 420)
  ;
  ; @return (s)
  [n]
  (/ n 1000))

(defn ms->m
  ; @param (ms) n
  ;
  ; @usage
  ; (ms->m 420)
  ;
  ; @return (m)
  [n]
  (/ n 60000))

(defn ms->h
  ; @param (ms) n
  ;
  ; @usage
  ; (ms->h 420)
  ;
  ; @return (h)
  [n]
  (/ n 3600000))

(defn ms->D
  ; @param (ms) n
  ;
  ; @usage
  ; (ms->D 420)
  ;
  ; @return (D)
  [n]
  (/ n 86400000))

(defn ms->W
  ; @param (ms) n
  ;
  ; @usage
  ; (ms->W 420)
  ;
  ; @return (W)
  [n]
  (/ n 604800000))

(defn s->ms
  ; @param (s) n
  ;
  ; @usage
  ; (s->ms 420)
  ;
  ; @return (ms)
  [n]
  (* n 1000))

(defn s->m
  ; @param (s) n
  ;
  ; @usage
  ; (s->m 420)
  ;
  ; @return (m)
  [n]
  (/ n 60))

(defn s->h
  ; @param (s) n
  ;
  ; @usage
  ; (s->h 420)
  ;
  ; @return (h)
  [n]
  (/ n 3600))

(defn s->D
  ; @param (s) n
  ;
  ; @usage
  ; (s->D 420)
  ;
  ; @return (D)
  [n]
  (/ n 86400))

(defn s->W
  ; @param (s) n
  ;
  ; @usage
  ; (s->W 420)
  ;
  ; @return (W)
  [n]
  (/ n 604800))

(defn m->ms
  ; @param (m) n
  ;
  ; @usage
  ; (m->ms 420)
  ;
  ; @return (ms)
  [n]
  (* n 60000))

(defn m->s
  ; @param (m) n
  ;
  ; @usage
  ; (m->s 420)
  ;
  ; @return (s)
  [n]
  (* n 60))

(defn m->h
  ; @param (m) n
  ;
  ; @usage
  ; (m->h 420)
  ;
  ; @return (h)
  [n]
  (/ n 60))

(defn m->D
  ; @param (m) n
  ;
  ; @usage
  ; (m->D 420)
  ;
  ; @return (D)
  [n]
  (/ n 1440))

(defn m->W
  ; @param (m) n
  ;
  ; @usage
  ; (m->W 420)
  ;
  ; @return (W)
  [n]
  (/ n 10800))

(defn h->ms
  ; @param (h) n
  ;
  ; @usage
  ; (h->ms 420)
  ;
  ; @return (ms)
  [n]
  (* n 3600000))

(defn h->s
  ; @param (h) n
  ;
  ; @usage
  ; (h->s 420)
  ;
  ; @return (s)
  [n]
  (* n 3600))

(defn h->m
  ; @param (h) n
  ;
  ; @usage
  ; (h->,óm 420)
  ;
  ; @return (m)
  [n]
  (* n 60))

(defn h->D
  ; @param (h) n
  ;
  ; @usage
  ; (h->D 420)
  ;
  ; @return (D)
  [n]
  (/ n 24))

(defn h->W
  ; @param (h) n
  ;
  ; @usage
  ; (h->W 420)
  ;
  ; @return (W)
  [n]
  (/ n 168))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn ms->time
  ; @param (float, integer or string) n
  ; @param (keyword)(opt) format
  ; :hhmmssmmm, :hhmmss
  ;
  ; @example
  ; (ms->time 260000)
  ; =>
  ; "00:04:20.000"
  ;
  ; @example
  ; (ms->time 260000.123)
  ; =>
  ; "00:04:20.000"
  ;
  ; @example
  ; (ms->time 260000 :hhmmss)
  ; =>
  ; "00:04:20"
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
