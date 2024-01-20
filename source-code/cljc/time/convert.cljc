
(ns time.convert
    (:require [fruits.format.api :as format]
              [fruits.math.api   :as math]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn ms->s
  ; @description
  ; Converts the given milliseconds value into seconds value.
  ;
  ; @param (ms) n
  ;
  ; @usage
  ; (ms->s 420)
  ; =>
  ; 0.42
  ;
  ; @return (s)
  [n]
  (/ n 1000))

(defn ms->m
  ; @description
  ; Converts the given milliseconds value into minutes value.
  ;
  ; @param (ms) n
  ;
  ; @usage
  ; (ms->m 420)
  ; =>
  ; 0.007
  ;
  ; @return (m)
  [n]
  (/ n 60000))

(defn ms->h
  ; @description
  ; Converts the given milliseconds value into hours value.
  ;
  ; @param (ms) n
  ;
  ; @usage
  ; (ms->h 420)
  ; =>
  ; 0.00011666'
  ;
  ; @return (h)
  [n]
  (/ n 3600000))

(defn ms->D
  ; @description
  ; Converts the given milliseconds value into days value.
  ;
  ; @param (ms) n
  ;
  ; @usage
  ; (ms->D 420)
  ; =>
  ; 0.00000486111'
  ;
  ; @return (D)
  [n]
  (/ n 86400000))

(defn ms->W
  ; @description
  ; Converts the given milliseconds value into weeks value.
  ;
  ; @param (ms) n
  ;
  ; @usage
  ; (ms->W 420)
  ; =>
  ; 0.00000069444'
  ;
  ; @return (W)
  [n]
  (/ n 604800000))

(defn s->ms
  ; @description
  ; Converts the given seconds value into milliseconds value.
  ;
  ; @param (s) n
  ;
  ; @usage
  ; (s->ms 420)
  ; =>
  ; 420000
  ;
  ; @return (ms)
  [n]
  (* n 1000))

(defn s->m
  ; @description
  ; Converts the given seconds value into minutes value.
  ;
  ; @param (s) n
  ;
  ; @usage
  ; (s->m 420)
  ; =>
  ; 7
  ;
  ; @return (m)
  [n]
  (/ n 60))

(defn s->h
  ; @description
  ; Converts the given seconds value into hours value.
  ;
  ; @param (s) n
  ;
  ; @usage
  ; (s->h 420)
  ; =>
  ; 0.11666'
  ;
  ; @return (h)
  [n]
  (/ n 3600))

(defn s->D
  ; @description
  ; Converts the given seconds value into days value.
  ;
  ; @param (s) n
  ;
  ; @usage
  ; (s->D 420)
  ; =>
  ; 0.00486111'
  ;
  ; @return (D)
  [n]
  (/ n 86400))

(defn s->W
  ; @description
  ; Converts the given seconds value into weeks value.
  ;
  ; @param (s) n
  ;
  ; @usage
  ; (s->W 420)
  ; =>
  ; 0.00069444'
  ;
  ; @return (W)
  [n]
  (/ n 604800))

(defn m->ms
  ; @description
  ; Converts the given minutes value into milliseconds value.
  ;
  ; @param (m) n
  ;
  ; @usage
  ; (m->ms 420)
  ; =>
  ; 25200000
  ;
  ; @return (ms)
  [n]
  (* n 60000))

(defn m->s
  ; @description
  ; Converts the given minutes value into seconds value.
  ;
  ; @param (m) n
  ;
  ; @usage
  ; (m->s 420)
  ; =>
  ; 25200
  ;
  ; @return (s)
  [n]
  (* n 60))

(defn m->h
  ; @description
  ; Converts the given minutes value into hours value.
  ;
  ; @param (m) n
  ;
  ; @usage
  ; (m->h 420)
  ; =>
  ; 7
  ;
  ; @return (h)
  [n]
  (/ n 60))

(defn m->D
  ; @description
  ; Converts the given minutes value into days value.
  ;
  ; @param (m) n
  ;
  ; @usage
  ; (m->h 420)
  ; =>
  ; 0.291666'
  ;
  ; @return (D)
  [n]
  (/ n 1440))

(defn m->W
  ; @description
  ; Converts the given minutes value into weeks value.
  ;
  ; @param (m) n
  ;
  ; @usage
  ; (m->W 420)
  ; =>
  ; 0.3888'
  ;
  ; @return (W)
  [n]
  (/ n 10800))

(defn h->ms
  ; @description
  ; Converts the given hours value into milliseconds value.
  ;
  ; @param (h) n
  ;
  ; @usage
  ; (h->ms 420)
  ; =>
  ; 1521000000
  ;
  ; @return (ms)
  [n]
  (* n 3600000))

(defn h->s
  ; @description
  ; Converts the given hours value into seconds value.
  ;
  ; @param (h) n
  ;
  ; @usage
  ; (h->s 420)
  ; =>
  ; 1512000
  ;
  ; @return (s)
  [n]
  (* n 3600))

(defn h->m
  ; @description
  ; Converts the given hours value into minutes value.
  ;
  ; @param (h) n
  ;
  ; @usage
  ; (h->m 420)
  ; =>
  ; 25200
  ;
  ; @return (m)
  [n]
  (* n 60))

(defn h->D
  ; @description
  ; Converts the given hours value into days value.
  ;
  ; @param (h) n
  ;
  ; @usage
  ; (h->D 420)
  ; =>
  ; 17.5
  ;
  ; @return (D)
  [n]
  (/ n 24))

(defn h->W
  ; @description
  ; Converts the given hours value into weeks value.
  ;
  ; @param (h) n
  ;
  ; @usage
  ; (h->W 420)
  ; =>
  ; 2.5
  ;
  ; @return (W)
  [n]
  (/ n 168))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn ms->time
  ; @description
  ; Converts the given milliseconds value into a formatted time string.
  ;
  ; @param (float, integer or string) n
  ; @param (keyword)(opt) format
  ; :hhmm, :hhmmss, :hhmmssmmm
  ; Default: :hhmmssmmm
  ;
  ; @usage
  ; (ms->time 260000)
  ; =>
  ; "00:04:20.000"
  ;
  ; @usage
  ; (ms->time 260000.123)
  ; =>
  ; "00:04:20.000"
  ;
  ; @usage
  ; (ms->time 260000 :hhmmss)
  ; =>
  ; "00:04:20"
  ;
  ; @return (string)
  ([n]
   (ms->time n :hhmmssmmm))

  ([n format]
   (if n (let [hours        (format/leading-zeros      (-> n ms->h math/floor)       2)
               minutes      (format/leading-zeros (rem (-> n ms->m math/floor)   60) 2)
               seconds      (format/leading-zeros (rem (-> n ms->s math/floor)   60) 2)
               milliseconds (format/leading-zeros (rem (-> n       math/floor) 1000) 3)]
              (case format :hhmmssmmm (str hours":"minutes":"seconds"."milliseconds)
                           :hhmmss    (str hours":"minutes":"seconds)
                           :hhmm      (str hours":"minutes))))))
