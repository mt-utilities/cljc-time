
;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns time.converters
    (:require [mid.time.converters :as converters]))



;; -- Redirects ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

; mid.time.converters
(def ms->s    converters/ms->s)
(def ms->m    converters/ms->m)
(def ms->h    converters/ms->h)
(def ms->D    converters/ms->D)
(def ms->W    converters/ms->W)
(def s->ms    converters/s->ms)
(def s->m     converters/s->m)
(def s->h     converters/s->h)
(def s->D     converters/s->D)
(def s->W     converters/s->W)
(def m->ms    converters/m->ms)
(def m->s     converters/m->s)
(def m->h     converters/m->h)
(def m->D     converters/m->D)
(def m->W     converters/m->W)
(def h->ms    converters/h->ms)
(def h->s     converters/h->s)
(def h->m     converters/h->m)
(def h->D     converters/h->D)
(def h->W     converters/h->W)
(def ms->time converters/ms->time)
